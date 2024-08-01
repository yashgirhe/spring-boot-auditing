![Auditing](https://github.com/user-attachments/assets/5f69a600-a6cd-4bcf-bafd-8a70c4423813)
# Working of auditing

1.@EntityListeners(AuditingEntityListener.class) annotation in Spring Boot is used to enable auditing features in your entity classes. This annotation is used to specify that a particular class should have its lifecycle events (like creation, update, etc.) listened to by the AuditingEntityListener. This listener provides automatic population of auditing fields such as createdDate, updatedDate, createdBy, and updatedBy.
AuditingEntityListener.class contains methods like - 

@PrePersist - triggered before saving entity. It will modify created date and created by column

@PreUpdate - triggered before update entity

2.@MappedSuperclass indicates that a class is a superclass and is not associated with a specific database table, but its fields (or properties) can be inherited by child entity classes that are associated with tables.

3.@Audited will audit all the fields in given entity. @NotAudited will exclude fields

