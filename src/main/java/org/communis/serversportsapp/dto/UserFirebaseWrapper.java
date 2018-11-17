package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.UserFirebase;

@Data
public class UserFirebaseWrapper implements ObjectWrapper<UserFirebase> {

    private Long id;
    private String uid;
    private String providerId;
    private Boolean isAnonymous;
    private String displayName;
    private String photoUrl;
    private String email;

    public UserFirebaseWrapper(){}

    public UserFirebaseWrapper(UserFirebase userFirebase){
        toWrapper(userFirebase);
    }

    @Override
    public void toWrapper(UserFirebase item) {
        if (item != null){
            id = item.getId();
            uid = item.getUid();
            providerId = item.getProviderId();
            isAnonymous = item.getIsAnonymous();
            displayName = item.getDisplayName();
            photoUrl = item.getPhotoUrl();
            email = item.getEmail();
        }
    }

    @Override
    public void fromWrapper(UserFirebase item) {
        if (item != null){
            item.setId(id);
            item.setUid(uid);
            item.setProviderId(providerId);
            item.setIsAnonymous(isAnonymous);
            item.setDisplayName(displayName);
            item.setPhotoUrl(photoUrl);
            item.setEmail(email);
        }
    }
}
