package org.communis.serversportsapp.dto;

import lombok.Data;
import org.communis.serversportsapp.entity.UserFirebase;

@Data
public class UserFirebaseWrapper implements ObjectWrapper<UserFirebase> {

    private Long id;
    private String uid;
    private String provider_id;
    private Boolean is_anonymous;
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
            provider_id = item.getProviderId();
            is_anonymous = item.getIsAnonymous();
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
            item.setProviderId(provider_id);
            item.setIsAnonymous(is_anonymous);
            item.setDisplayName(displayName);
            item.setPhotoUrl(photoUrl);
            item.setEmail(email);
        }
    }
}
