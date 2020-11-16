package com.another.demodomain.rds.user

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user")
class User : Serializable {

    companion object {
        fun create(email: String) =
            User().apply {
                this.email = email
            }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    @Column(name = "email", unique = true, nullable = false, length = 100)
    var email: String = ""
        protected set
}