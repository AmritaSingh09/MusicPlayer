package com.proj.MusicPlayer.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetailModal {

    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String id;
    private String name, email, password, age,phone;

    @DBRef
    private Set<RolesModal> roles;

}
