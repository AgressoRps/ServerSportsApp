package org.communis.serversportsapp.enums;

public enum DifficultyState {
    EASY{}, AVERAGE{}, HEAVY{};

    /**
     * Метод получения сложности выполнения тренировочного дня в строковом виде
     * @return сложность выполнения
     */
    public String getStringName(){
        switch (this){
            case EASY:
                return "Easy complexity";
            case AVERAGE:
                return "Average complexity";
            case HEAVY:
                return "Heavy complexity";
            default:
                return null;
        }
    }
}
