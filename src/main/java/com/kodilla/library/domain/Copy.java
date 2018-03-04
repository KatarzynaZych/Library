package com.kodilla.library.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Entity
@Table(name = "Copies")
public class Copy {

 public Copy(int copyId, int titleId, String state) {
  this.copyId = copyId;
  this.state = state;
 }

 @Id
 @NotNull
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name = "copyId")
 private int copyId;

 @ManyToOne
 @JoinColumn(name = "titleId")
 private Title title;

 public void setTitle(Title title) {
  this.title = title;
 }

 @Column(name = "state")
 private String state;

 @OneToMany(
         targetEntity = Lends.class,
         mappedBy = "copy",
         cascade = CascadeType.ALL,
         fetch = FetchType.EAGER
 )
 private List<Lends> rents = new ArrayList<>();
}

