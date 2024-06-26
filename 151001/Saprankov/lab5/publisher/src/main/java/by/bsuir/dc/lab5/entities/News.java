package by.bsuir.dc.lab5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="news",schema = "distcomp")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "editor_id",nullable = false)
    private Long editorId;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "created",nullable = false)
    private Date created = new Date(System.currentTimeMillis());

    @Column(name = "modified",nullable = false)
    private Date modified = new Date(System.currentTimeMillis());;
}
