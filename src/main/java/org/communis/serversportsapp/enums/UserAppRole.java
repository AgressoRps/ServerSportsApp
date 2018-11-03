package org.communis.serversportsapp.enums;

public enum UserAppRole {
    ROLE_ADMIN{}, ROLE_MODERATOR{}, ROLE_USER{};

    public String getStringName(){
        switch (this){
            case ROLE_USER:
                return "User";
            case ROLE_MODERATOR:
                return "Moderator";
            case ROLE_ADMIN:
                return "Administrator";
        }
    }
}
