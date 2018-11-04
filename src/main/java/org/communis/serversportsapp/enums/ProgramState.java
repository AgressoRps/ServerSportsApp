package org.communis.serversportsapp.enums;

public enum ProgramState {
    COMPLETED{}, STARTED{}, AVAILABLE{};

    /**
     * Метод получения текущего состояния тренировочной программы в строковом виде
     * @return текущее состояние тренировочной программы
     */
    public String getStringName(){
        switch (this){
            case AVAILABLE:
                return "Available";
            case STARTED:
                return "Started";
            case COMPLETED:
                return "Completed";
            default:
                return null;
        }
    }
}
