package dev.be.awskotlinpractice.domain

import javax.persistence.*

@Entity
@Table
class Kowit(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var description: String,
) : BaseTimeEntity() {}
