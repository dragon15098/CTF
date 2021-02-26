package com.myjavablog.service.impl;

import com.myjavablog.model.Invitation;
import com.myjavablog.model.User;
import com.myjavablog.model.UserRoom;
import com.myjavablog.repository.InvitationRepository;
import com.myjavablog.service.InvitationService;
import com.myjavablog.service.UserRoomService;
import com.myjavablog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvitationServiceImpl implements InvitationService {

    private final InvitationRepository invitationRepository;

    private final UserService userService;

    private final UserRoomService userRoomService;

    @Override
    public Invitation createInvitation(Integer roomId, Integer userId, String toUserName) {
        User user = userService.findUserByEmail(toUserName);
        if (user != null) {
            Invitation invitation = new Invitation();
            invitation.setRoomId(roomId);
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
            UserRoom userRoom = userRoomService.addUserToRoom(invitation.getToUserId(), invitation.getRoomId());
            if (userRoom.getId() != null) {
                invitationRepository.delete(invitation);
                return userRoom;
            }
        }
        return null;
    }

    @Override
    public List<Invitation> getInvitationIdsByUserId(Integer invitationId) {
        return invitationRepository.findByToUserId(invitationId);
    }
}
