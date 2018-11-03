package org.communis.serversportsapp.enums;

public enum UserState {
    ONLINE{}, OFFLINE{}, BLOCKED{}, REMOVED{};

    /**
     * Метод получения текущего состояния пользователя в строковом виде
     * @return текущее состояние пользователя
     */
    public String getStringName(){
        switch (this){
            case OFFLINE:
                return "Offline";
            case ONLINE:
                return "Online";
            case BLOCKED:
                return "Blocked";
            case REMOVED:
                return "Removed";
            default:
                return null;
        }
    }
}
