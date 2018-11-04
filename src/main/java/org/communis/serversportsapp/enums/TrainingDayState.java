package org.communis.serversportsapp.enums;

public enum TrainingDayState {
    COMPLETED{}, AVAILABLE{};

    /**
     * Метод получения текущего состояния тренировочного дня в строковом виде
     * @return текущее состояние тренировочного дня
     */
    public String getStringName(){
        switch (this){
            case AVAILABLE:
                return "Available";
            case COMPLETED:
                return "Completed";
            default:
                return null;
        }
    }
}
