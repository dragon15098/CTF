package com.myjavablog.service.impl;

import com.myjavablog.model.Invitation;
import com.myjavablog.model.User;
import com.myjavablog.model.UserRoom;
import com.myjavablog.repository.InvitationRepository;
import com.myjavablog.repository.UserRoomRepository;
import com.myjavablog.service.InvitationService;
import com.myjavablog.service.UserRoomService;
import com.myjavablog.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {

    private final InvitationRepository invitationRepository;

    private final UserService userService;

    private final UserRoomService userRoomService;

    private final UserRoomRepository userRoomRepository;

    public InvitationServiceImpl(InvitationRepository invitationRepository, UserService userService, UserRoomService userRoomService, UserRoomRepository userRoomRepository) {
        this.invitationRepository = invitationRepository;
        this.userService = userService;
        this.userRoomService = userRoomService;
        this.userRoomRepository = userRoomRepository;
    }

    @Override
    public Invitation createInvitation(Integer roomId, Integer fromUserId, String toUserName) {
        // TODO add some filter
        User user = userService.findUserByEmail(toUserName);
        if (user != null) {
            Invitation invitation = new Invitation();
            invitation.setRoomId(roomId);
            invitation.setFromUserId(fromUserId);
            invitation.setToUserId(user.getId());
            invitation.setStatus(0);
            invitationRepository.save(invitation);
        }
        return null;
    }

    @Override
    public UserRoom acceptInvitation(Integer invitationId) {
        Invitation invitation = invitationRepository.findById(invitationId).orElse(null);
        if (invitation != null) {
            if (userNotInRoom(invitation.getRoomId(), invitation.getToUserId())) {
                UserRoom userRoom = userRoomService.addUserToRoom(invitation.getToUserId(), invitation.getRoomId());
                if (userRoom.getId() != null) {
                    invitationRepository.delete(invitation);
                    return userRoom;
                }
            }

        }
        return null;
    }

    private boolean userNotInRoom(Integer roomId, Integer userId) {
        UserRoom userRoom = userRoomRepository.findByUserIdAndRoomId(userId, roomId);
        return userRoom == null;
    }

    @Override
    public List<Invitation> getInvitationIdsByUserId(Integer invitationId) {
        return invitationRepository.findByToUserId(invitationId);
    }
}
