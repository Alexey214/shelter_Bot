package jd5.ShelterBot.shelterBot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

//Я бы оставил тут только id, telegramId и указание на id в таблице усыновителя, можно еще вытащить никнеймпользователя  в телеге.
//Имя и фамилию из чата не вытащить насколько я знаю
//Пока не добавляю создание таблиц для них, надо сначала понять как они будут выглядеть в итоге


@Entity
public class ShelterUser {

    @Id
    @GeneratedValue
    private Long id;

    private Long telegramId;
    private String name;
    private String surname;

    public ShelterUser(Long telegramId, String name, String surname) {
        this.telegramId = telegramId;
        this.name = name;
        this.surname = surname;
    }

    public ShelterUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(Long telegramId) {
        this.telegramId = telegramId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelterUser that = (ShelterUser) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
