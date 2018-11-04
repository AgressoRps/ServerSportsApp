package org.communis.serversportsapp.enums;

public enum ExerciseTimeState {
    ON_TIME{}, OUT_OF_TIME{};

    /**
     * Метод получения текущего состояния упражнения в строковом виде
     * @return текущее состояние упражнения
     */
    public String getStringName(){
        switch (this){
            case ON_TIME:
                return "On time";
            case OUT_OF_TIME:
                return "Out of time";
            default:
                return null;
        }
    }

}
