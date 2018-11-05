package org.communis.serversportsapp.enums;

public enum MoodState {
    NOTHING{}, INDIFFERENT{}, ACTIVE{}, GOOD{};

    /**
     * Метод получения текущего настроения пользователя в строковом виде
     * @return настроение пользователя
     */
    public String getStringName(){
        switch (this){
            case NOTHING:
                return "I want nothing";
            case INDIFFERENT:
                return "Indifferent";
            case ACTIVE:
                return "Active";
            case GOOD:
                return "Very good";
            default:
                return null;
        }
    }
}
