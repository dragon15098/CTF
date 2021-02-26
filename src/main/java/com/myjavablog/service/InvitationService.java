package com.myjavablog.service;


import com.myjavablog.model.Invitation;
import com.myjavablog.model.UserRoom;

import java.util.List;

public interface InvitationService {
    Invitation createInvitation(Integer roomId, Integer userId, String toUserName);

    UserRoom acceptInvitation(Integer invitationId);

    List<Invitation> getInvitationIdsByUserId(Integer invitationId);


}
