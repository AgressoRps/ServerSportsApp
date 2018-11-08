package org.communis.serversportsapp.exception.error;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeConstants {
    public static final Map<ErrorCodeIdentifier, String> messages = new HashMap<>();

    public static final ErrorCodeIdentifier BASE = new ErrorCodeIdentifier("0");
    public static final ErrorCodeIdentifier DATA_NOT_FOUND = BASE.branch("1");
    public static final ErrorCodeIdentifier ACCESS_ERROR = BASE.branch("2");
    public static final ErrorCodeIdentifier DATA_VALIDATE_ERROR = BASE.branch("3");

    public static final ErrorCodeIdentifier USER = new ErrorCodeIdentifier("1");
    public static final ErrorCodeIdentifier USER_LIST_ERROR = USER.branch("1");
    public static final ErrorCodeIdentifier USER_INFO_ERROR = USER.branch("2");

    public static final ErrorCodeIdentifier USER_ADD_ERROR = USER.branch("3");
    public static final ErrorCodeIdentifier USER_LOGIN_ALREADY_EXIST = USER_ADD_ERROR.branch("1");
    public static final ErrorCodeIdentifier USER_MAIL_ALREADY_EXIST = USER_ADD_ERROR.branch("1");

    public static final ErrorCodeIdentifier USER_PASSWORD_ERROR = USER.branch("4");
    public static final ErrorCodeIdentifier USER_PASSWORD_LENGTH_ERROR = USER_PASSWORD_ERROR.branch("1");
    public static final ErrorCodeIdentifier USER_PASSWORD_COMPARE_ERROR = USER_PASSWORD_ERROR.branch("2");

    public static final ErrorCodeIdentifier USER_UPDATE_ERROR = USER.branch("5");
    public static final ErrorCodeIdentifier USER_BLOCK_ERROR = USER.branch("6");
    public static final ErrorCodeIdentifier USER_BLOCK_SELF_ERROR = USER_BLOCK_ERROR.branch("1");

    public static final ErrorCodeIdentifier USER_UNBLOCK_ERROR = USER.branch("7");
    public static final ErrorCodeIdentifier USER_DELETE_ERROR = USER.branch("8");

    public static final ErrorCodeIdentifier TRAINING_PROGRAM = new ErrorCodeIdentifier("2");
    public static final ErrorCodeIdentifier TRAINING_PROGRAM_LIST_ERROR = TRAINING_PROGRAM.branch("1");
    public static final ErrorCodeIdentifier TRAINING_PROGRAM_INFO_ERROR = TRAINING_PROGRAM.branch("2");
    public static final ErrorCodeIdentifier TRAINING_PROGRAM_ADD_ERROR = TRAINING_PROGRAM.branch("3");
    public static final ErrorCodeIdentifier TRAINING_PROGRAM_UPDATE_ERROR = TRAINING_PROGRAM.branch("4");
    public static final ErrorCodeIdentifier TRAINING_PROGRAM_DELETE_ERROR = TRAINING_PROGRAM.branch("5");

    public static final ErrorCodeIdentifier TRAINING_DAY = new ErrorCodeIdentifier("3");
    public static final ErrorCodeIdentifier TRAINING_DAY_LIST_ERROR = TRAINING_DAY.branch("1");
    public static final ErrorCodeIdentifier TRAINING_DAY_INFO_ERROR = TRAINING_DAY.branch("2");
    public static final ErrorCodeIdentifier TRAINING_DAY_ADD_ERROR = TRAINING_DAY.branch("3");
    public static final ErrorCodeIdentifier TRAINING_DAY_UPDATE_ERROR = TRAINING_DAY.branch("4");
    public static final ErrorCodeIdentifier TRAINING_DAY_DELETE_ERROR = TRAINING_DAY.branch("5");

    public static final ErrorCodeIdentifier PROGRESS = new ErrorCodeIdentifier("4");
    public static final ErrorCodeIdentifier PROGRESS_LIST_ERROR = PROGRESS.branch("1");
    public static final ErrorCodeIdentifier PROGRESS_INFO_ERROR = PROGRESS.branch("2");
    public static final ErrorCodeIdentifier PROGRESS_ADD_ERROR = PROGRESS.branch("3");
    public static final ErrorCodeIdentifier PROGRESS_UPDATE_ERROR = PROGRESS.branch("4");
    public static final ErrorCodeIdentifier PROGRESS_DELETE_ERROR = PROGRESS.branch("5");

    public static final ErrorCodeIdentifier RANK = new ErrorCodeIdentifier("5");
    public static final ErrorCodeIdentifier RANK_LIST_ERROR = RANK.branch("1");
    public static final ErrorCodeIdentifier RANK_INFO_ERROR = RANK.branch("2");
    public static final ErrorCodeIdentifier RANK_ADD_ERROR = RANK.branch("3");
    public static final ErrorCodeIdentifier RANK_UPDATE_ERROR = RANK.branch("4");
    public static final ErrorCodeIdentifier RANK_DELETE_ERROR = RANK.branch("5");

    public static final ErrorCodeIdentifier LEVEL_DIFFICULTY = new ErrorCodeIdentifier("6");
    public static final ErrorCodeIdentifier LEVEL_DIFFICULTY_LIST_ERROR = LEVEL_DIFFICULTY.branch("1");
    public static final ErrorCodeIdentifier LEVEL_DIFFICULTY_INFO_ERROR = LEVEL_DIFFICULTY.branch("2");
    public static final ErrorCodeIdentifier LEVEL_DIFFICULTY_ADD_ERROR = LEVEL_DIFFICULTY.branch("3");
    public static final ErrorCodeIdentifier LEVEL_DIFFICULTY_UPDATE_ERROR = LEVEL_DIFFICULTY.branch("4");
    public static final ErrorCodeIdentifier LEVEL_DIFFICULTY_DELETE_ERROR = LEVEL_DIFFICULTY.branch("5");

    public static final ErrorCodeIdentifier TRAINING_LOCATION = new ErrorCodeIdentifier("7");
    public static final ErrorCodeIdentifier TRAINING_LOCATION_LIST_ERROR = TRAINING_LOCATION.branch("1");
    public static final ErrorCodeIdentifier TRAINING_LOCATION_INFO_ERROR = TRAINING_LOCATION.branch("2");
    public static final ErrorCodeIdentifier TRAINING_LOCATION_ADD_ERROR = TRAINING_LOCATION.branch("3");
    public static final ErrorCodeIdentifier TRAINING_LOCATION_UPDATE_ERROR = TRAINING_LOCATION.branch("4");
    public static final ErrorCodeIdentifier TRAINING_LOCATION_DELETE_ERROR = TRAINING_LOCATION.branch("5");

    public static final ErrorCodeIdentifier PROGRESS_USER = new ErrorCodeIdentifier("8");
    public static final ErrorCodeIdentifier PROGRESS_USER_LIST_ERROR = PROGRESS_USER.branch("1");
    public static final ErrorCodeIdentifier PROGRESS_USER_INFO_ERROR = PROGRESS_USER.branch("2");
    public static final ErrorCodeIdentifier PROGRESS_USER_ADD_ERROR = PROGRESS_USER.branch("3");
    public static final ErrorCodeIdentifier PROGRESS_USER_UPDATE_ERROR = PROGRESS_USER.branch("4");
    public static final ErrorCodeIdentifier PROGRESS_USER_DELETE_ERROR = PROGRESS_USER.branch("5");

    public static final ErrorCodeIdentifier FRIEND = new ErrorCodeIdentifier("9");
    public static final ErrorCodeIdentifier FRIEND_LIST_ERROR = FRIEND.branch("1");
    public static final ErrorCodeIdentifier FRIEND_INFO_ERROR = FRIEND.branch("2");
    public static final ErrorCodeIdentifier FRIEND_ADD_ERROR = FRIEND.branch("3");
    public static final ErrorCodeIdentifier FRIEND_UPDATE_ERROR = FRIEND.branch("4");
    public static final ErrorCodeIdentifier FRIEND_DELETE_ERROR = FRIEND.branch("5");

    public static final ErrorCodeIdentifier RANK_USER = new ErrorCodeIdentifier("10");
    public static final ErrorCodeIdentifier RANK_USER_LIST_ERROR = RANK_USER.branch("1");
    public static final ErrorCodeIdentifier RANK_USER_INFO_ERROR = RANK_USER.branch("2");
    public static final ErrorCodeIdentifier RANK_USER_ADD_ERROR = RANK_USER.branch("3");
    public static final ErrorCodeIdentifier RANK_USER_UPDATE_ERROR = RANK_USER.branch("4");
    public static final ErrorCodeIdentifier RANK_USER_DELETE_ERROR = RANK_USER.branch("5");

    public static final ErrorCodeIdentifier DAY = new ErrorCodeIdentifier("11");
    public static final ErrorCodeIdentifier DAY_LIST_ERROR = DAY.branch("1");
    public static final ErrorCodeIdentifier DAY_INFO_ERROR = DAY.branch("2");
    public static final ErrorCodeIdentifier DAY_ADD_ERROR = DAY.branch("3");
    public static final ErrorCodeIdentifier DAY_UPDATE_ERROR = DAY.branch("4");
    public static final ErrorCodeIdentifier DAY_DELETE_ERROR = DAY.branch("5");

    public static final ErrorCodeIdentifier EXERCISE = new ErrorCodeIdentifier("12");
    public static final ErrorCodeIdentifier EXERCISE_LIST_ERROR = EXERCISE.branch("1");
    public static final ErrorCodeIdentifier EXERCISE_INFO_ERROR = EXERCISE.branch("2");
    public static final ErrorCodeIdentifier EXERCISE_ADD_ERROR = EXERCISE.branch("3");
    public static final ErrorCodeIdentifier EXERCISE_UPDATE_ERROR = EXERCISE.branch("4");
    public static final ErrorCodeIdentifier EXERCISE_DELETE_ERROR = EXERCISE.branch("5");

    public static final ErrorCodeIdentifier TRAINING_DAY_CONTENT = new ErrorCodeIdentifier("13");
    public static final ErrorCodeIdentifier TRAINING_DAY_CONTENT_LIST_ERROR = TRAINING_DAY_CONTENT.branch("1");
    public static final ErrorCodeIdentifier TRAINING_DAY_CONTENT_INFO_ERROR = TRAINING_DAY_CONTENT.branch("2");
    public static final ErrorCodeIdentifier TRAINING_DAY_CONTENT_ADD_ERROR = TRAINING_DAY_CONTENT.branch("3");
    public static final ErrorCodeIdentifier TRAINING_DAY_CONTENT_UPDATE_ERROR = TRAINING_DAY_CONTENT.branch("4");
    public static final ErrorCodeIdentifier TRAINING_DAY_CONTENT_DELETE_ERROR = TRAINING_DAY_CONTENT.branch("5");



    static {
        messages.put(DATA_NOT_FOUND, "Ошибка при получении данных");
        messages.put(ACCESS_ERROR, "Доступ запрещен");
        messages.put(DATA_VALIDATE_ERROR, "Отправленные данные некорректны");

        messages.put(USER_LIST_ERROR, "Ошибка при получении списка пользователей");
        messages.put(USER_INFO_ERROR, "Ошибка при получении пользователя");

        messages.put(USER_ADD_ERROR, "Ошибка при добавлении пользователя");
        messages.put(USER_LOGIN_ALREADY_EXIST, "Логин занят другим пользователем");
        messages.put(USER_MAIL_ALREADY_EXIST, "Указанная почта уже используется");

        messages.put(USER_PASSWORD_ERROR, "Ошибка при изменении пароля пользователя");
        messages.put(USER_PASSWORD_LENGTH_ERROR, "Некорректная длина пароля");
        messages.put(USER_PASSWORD_COMPARE_ERROR, "Пароли не совпадают");

        messages.put(USER_UPDATE_ERROR, "Ошибка при изменении пользователя");
        messages.put(USER_BLOCK_ERROR, "Ошибка при блокировке пользователя");
        messages.put(USER_BLOCK_SELF_ERROR, "Нельзя заблокировать себя");

        messages.put(USER_UNBLOCK_ERROR, "Ошибка при разблокировке пользователя");

        messages.put(TRAINING_PROGRAM_LIST_ERROR, "Ошибка при получении списка тренировочных программ");
        messages.put(TRAINING_PROGRAM_INFO_ERROR, "Ошибка при получении тренировочной программы");
        messages.put(TRAINING_PROGRAM_ADD_ERROR, "Ошибка при добавлении тренировочной программы");
        messages.put(TRAINING_PROGRAM_UPDATE_ERROR, "Ошибка при изменении тренировочной программы");
        messages.put(TRAINING_PROGRAM_DELETE_ERROR, "Ошибка при удалении тренировочной программы");

        messages.put(TRAINING_DAY_LIST_ERROR, "Ошибка при получении списка тренировочных дней");
        messages.put(TRAINING_DAY_INFO_ERROR, "Ошибка при получении тренировочного дня");
        messages.put(TRAINING_DAY_ADD_ERROR, "Ошибка при добавлении тренировочного дня");
        messages.put(TRAINING_DAY_UPDATE_ERROR, "Ошибка при изменении тренировочного дня");
        messages.put(TRAINING_DAY_DELETE_ERROR, "Ошибка при удалении тренировочного дня");

        messages.put(PROGRESS_LIST_ERROR, "Ошибка при получении списка всех достижений");
        messages.put(PROGRESS_INFO_ERROR, "Ошибка при получении достижения");
        messages.put(PROGRESS_ADD_ERROR, "Ошибка при добавлении достижения");
        messages.put(PROGRESS_UPDATE_ERROR, "Ошибка при изменении достижения");
        messages.put(PROGRESS_DELETE_ERROR, "Ошибка при удалении достижения");

        messages.put(RANK_LIST_ERROR, "Ошибка при получении списка всех званий");
        messages.put(RANK_INFO_ERROR, "Ошибка при получении звания");
        messages.put(RANK_ADD_ERROR, "Ошибка при добавлении звания");
        messages.put(RANK_UPDATE_ERROR, "Ошибка при изменении звания");
        messages.put(RANK_DELETE_ERROR, "Ошибка при удалении звания");

        messages.put(LEVEL_DIFFICULTY_LIST_ERROR, "Ошибка при получении списка всех уровней сложности");
        messages.put(LEVEL_DIFFICULTY_INFO_ERROR, "Ошибка при получении уровня сложности");
        messages.put(LEVEL_DIFFICULTY_ADD_ERROR, "Ошибка при добавлении уровня сложности");
        messages.put(LEVEL_DIFFICULTY_UPDATE_ERROR, "Ошибка при изменении уровня сложности");
        messages.put(LEVEL_DIFFICULTY_DELETE_ERROR, "Ошибка при удалении уровня сложности");

        messages.put(TRAINING_LOCATION_LIST_ERROR, "Ошибка при получении списка всех тренировочных локаций");
        messages.put(TRAINING_LOCATION_INFO_ERROR, "Ошибка при получении тренировочной локации");
        messages.put(TRAINING_LOCATION_ADD_ERROR, "Ошибка при добавлении тренировочной локации");
        messages.put(TRAINING_LOCATION_UPDATE_ERROR, "Ошибка при изменении тренировочной локации");
        messages.put(TRAINING_LOCATION_DELETE_ERROR, "Ошибка при удалении тренировочной локации");

        messages.put(PROGRESS_USER_LIST_ERROR, "Ошибка при получении списка всех достижений пользователей");
        messages.put(PROGRESS_USER_INFO_ERROR, "Ошибка при получении достижения пользователя");
        messages.put(PROGRESS_USER_ADD_ERROR, "Ошибка при добавлении достижения пользователя");
        messages.put(PROGRESS_USER_UPDATE_ERROR, "Ошибка при изменении достижения пользователя");
        messages.put(PROGRESS_USER_DELETE_ERROR, "Ошибка при удалении достижения пользователя");

        messages.put(FRIEND_LIST_ERROR, "Ошибка при получении списка всех друзей");
        messages.put(FRIEND_INFO_ERROR, "Ошибка при получении информации о друге");
        messages.put(FRIEND_ADD_ERROR, "Ошибка при добавлении нового друга");
        messages.put(FRIEND_UPDATE_ERROR, "Ошибка при изменении друга");
        messages.put(FRIEND_DELETE_ERROR, "Ошибка при удалении друга");

        messages.put(RANK_USER_LIST_ERROR, "Ошибка при получении списка всех рангов пользователя");
        messages.put(RANK_USER_INFO_ERROR, "Ошибка при получении информации о ранге пользователя");
        messages.put(RANK_USER_ADD_ERROR, "Ошибка при добавлении нового ранга пользователю");
        messages.put(RANK_USER_UPDATE_ERROR, "Ошибка при изменении ранга пользователя");
        messages.put(RANK_USER_DELETE_ERROR, "Ошибка при удалении ранга пользователя");

        messages.put(DAY_LIST_ERROR, "Ошибка при получении списка всех дней");
        messages.put(DAY_INFO_ERROR, "Ошибка при получении информации о дне");
        messages.put(DAY_ADD_ERROR, "Ошибка при добавлении нового дня");
        messages.put(DAY_UPDATE_ERROR, "Ошибка при изменении дня");
        messages.put(DAY_DELETE_ERROR, "Ошибка при удалении дня");

        messages.put(EXERCISE_LIST_ERROR, "Ошибка при получении списка упражнений");
        messages.put(EXERCISE_INFO_ERROR, "Ошибка при получении информации об упражнении");
        messages.put(EXERCISE_ADD_ERROR, "Ошибка при добавлении нового упражнения");
        messages.put(EXERCISE_UPDATE_ERROR, "Ошибка при изменении упражнения");
        messages.put(EXERCISE_DELETE_ERROR, "Ошибка при удалении упражнения");

        messages.put(TRAINING_DAY_CONTENT_LIST_ERROR, "Ошибка при получении списка содержания тренировочного дня");
        messages.put(TRAINING_DAY_CONTENT_INFO_ERROR, "Ошибка при получении информации о содержании тренировочного дня");
        messages.put(TRAINING_DAY_CONTENT_ADD_ERROR, "Ошибка при добавлении содержания тренировочного дня");
        messages.put(TRAINING_DAY_CONTENT_UPDATE_ERROR, "Ошибка при изменении содержания тренировочного дня");
        messages.put(TRAINING_DAY_CONTENT_DELETE_ERROR, "Ошибка при удалении содержания тренировочного дня");
    }
}
