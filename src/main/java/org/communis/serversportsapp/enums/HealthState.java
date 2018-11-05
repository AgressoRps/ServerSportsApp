package org.communis.serversportsapp.enums;

public enum HealthState {
    WEAKNESS{}, MUSCLE_PAIN{}, NORMAL{}, CHEERFULNESS{};

    /**
     * Метод получения текущего состояния пользователя в строковом виде
     * @return состояние пользователя
     */
    public String getStringName(){
        switch (this){
            case WEAKNESS:
                return "Weakness";
            case MUSCLE_PAIN:
                return "Muscle pain";
            case NORMAL:
                return "Normal";
            case CHEERFULNESS:
                return "Cheerfulness";
            default:
                return null;
        }
    }
}
