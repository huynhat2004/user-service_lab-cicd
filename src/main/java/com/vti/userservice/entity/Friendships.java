package com.vti.userservice.entity;

import com.vti.userservice.entity.enumm.FriendshipStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FRIENDSHIPS")
public class Friendships {
    @Id
    @GeneratedValue
    private Integer id;

    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User userID;

    @JoinColumn(name = "FRIEND_ID", referencedColumnName = "ID")
    @ManyToOne
    private User friendID;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private FriendshipStatus status;

    @Column(name = "CREATED_AT")
    private Instant createdAt;
}
