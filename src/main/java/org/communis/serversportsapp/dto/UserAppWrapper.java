package org.communis.serversportsapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.communis.serversportsapp.entity.UserApp;
import org.communis.serversportsapp.enums.UserAppRole;
import org.communis.serversportsapp.enums.UserState;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserAppWrapper implements ObjectWrapper<UserApp>, Serializable {

    private final String EMAIL_REGEXP = "(.+@.+)";

    private Long id;

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 30)
    private String surname;

    @NotNull
    @Size(max = 36)
    private String login;

    @NotNull
    @Size(max = 50)
    private String email;

    @JsonIgnore
    @Size(min = 8, max = 20)
    private String password;

    @JsonIgnore
    @Size(min = 8, max = 20)
    private String confirmPassword;

    private UserAppRole role;

    private UserState state;

    public UserAppWrapper(){

    }

    public UserAppWrapper(UserApp userApp){
        toWrapper(userApp);
    }

    /**
     * Добавление данных объекта UserApp в объект UserAppWrapper
     * @param item - экземпляр объекта UserApp
     */
    @Override
    public void toWrapper(UserApp item) {
        if (item != null){
            id = item.getId();
            name = item.getName();
            surname = item.getSurname();
            login = item.getLogin();
            email = item.getEmail();
            password = item.getPassword();
            role = item.getRole();
            state = item.getUserState();
        }
    }

    /**
     * Получение допустимой информации об объекте, для отправки клиенту
     * @param item - экземпляр объекта UserApp, содержит только допустимые для отправки данные
     */
    @Override
    public void fromWrapper(UserApp item) {
        if (item != null){
            item.setId(id);
            item.setName(name);
            item.setSurname(surname);
            item.setLogin(login);
            item.setEmail(email);
            item.setPassword(password);
            item.setRole(role);
            item.setUserState(state);
        }
    }

    /**
     * Метод получения фамилии и имени
     * @return строка, содержащая фамилию и имя пользователя
     */
    public String getFio(){
        return surname.concat(" ").concat(name);
    }

    /**
     * Метод валидации пароля при регистрации
     * @return если пароль и пароль подтверждения совпадают - true
     */
    @AssertTrue
    public boolean isPasswordValid() {
        return (password == null && confirmPassword == null) ||
                (password != null && confirmPassword != null && password.equals(confirmPassword));
    }

    /**
     * Проверка, заблокирован ли пользователь
     * @return если пользователь заблокирован - true
     */
    public boolean isBlocked(){
        return state == UserState.BLOCKED;
    }

    /**
     * Проверка, удален ли пользователь
     * @return если пользователь удален - true
     */
    public boolean isRemoved(){
        return state == UserState.REMOVED;
    }
}
