package hhr.entity;

import org.thymeleaf.spring5.expression.Fields;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "project")
public class ProjectCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int id; // ID проекта
    public  String author;// Автор карточки
    public  String client; // Кто заказчик проекта
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "card_status")
    public  CardStatus cardStatus; // Статус карточки
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_type")
    public  ProjectType projectType; // Тип проекта
    public  String name; // Наименование проекта
    @Basic
    @Column(name = "func_area",length = 65535,columnDefinition="Text")
    public   String funcArea; // Функциональное направление
    @Basic
    @Column(name = "subject_area", length = 65535,columnDefinition="Text")
    public  String subjectArea; // Предметная область проекта
    @Column(length = 65535,columnDefinition="Text")
    public  String description; // Описание проекта
    @Column(length = 65535,columnDefinition="Text")
    public  String tasks; // Задачи, которые придется решать на проекте
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "stage")
    public  ProjectStage stage; // Стадия проекта
    @Basic
    @Column(name = "dead_line")
    public   LocalDate deadLine; // Срок завершения проекта
    @Column(length = 65535,columnDefinition="Text")
    public  String technoligies; // Технологии
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "dev_method")
    public DevMethodology devMethod; // Методология разработки
    public  String stakeHolders; //Сколько стейкхолдеров на проекте
    public  Boolean product; // Продуктовая разработка
    public  int analitics; // Количество аналитиков
    public   int devs; // Количество разработчиков
    public   Boolean testers; // Тестировщики
    public Boolean techWriters; // Техписы
    int team; // Количесво людей в команде
    @Column(length = 65535,columnDefinition="Text")
    public  String location; // Локация
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "timeplan")
    public TimePlan timeplan; // График времени
    @Basic
    @Column(name = "deadline_hr")
    public LocalDate deadlineHR; // Дата вывода людей на проект
    @OneToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "overtimes")
    public  Overtimes overtimes; // Овертаймы
    @Column(name = "hr_details",length = 65535,columnDefinition="Text")
    public  String hrDetails; // Процедура вывода людей
    public  Boolean gost; // Будет ли документирование по ГОСТ


    public ProjectCard(){}

    public void setId(int id) {
        this.id = id;
    }

    public ProjectCard(String client, String funcArea,
                       String subjectArea, String description, String tasks,
                       Boolean gost, String hrDetails, CardStatus cardStatus )
    {
        this.client = client;
        this.funcArea= funcArea;
        this.subjectArea = subjectArea;
        this.description = description;
        this.tasks = tasks;
        this.gost = gost;
        this.hrDetails = hrDetails;
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public String getCardStatus() {
        return cardStatus.name;
    }

    public String getProjectType() {
        return projectType.name;
    }



    public String getName() {
        return name;
    }

    public String getFuncArea() {
        return funcArea;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public String getDescription() {
        return description;
    }

    public String getTasks() {
        return tasks;
    }

    public String getStage() {
        return stage.name;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public String getTechnoligies() {
        return technoligies;
    }

    public String getDevMethod() {
        return devMethod.name;
    }

    public String getStakeHolders() {
        return stakeHolders;
    }

    public Boolean getProduct() {
        return product;
    }

    public int getAnalitics() {
        return analitics;
    }

    public int getDevs() {
        return devs;
    }

    public Boolean getTesters() {
        return testers;
    }

    public Boolean getTechWriters() {
        return techWriters;
    }

    public int getTeam() {
        return team;
    }

    public String getLocation() {
        return location;
    }

    public String getTimeplan() {
        return timeplan.name;
    }

    public LocalDate getDeadlineHR() {
        return deadlineHR;
    }

    public String getOvertimes() {
        return overtimes.name;
    }

    public String getHrDetails() {
        return hrDetails;
    }

    public Boolean getGost() {
        return gost;
    }

    public String getAuthor() {
        return author;
    }


    public ArrayList<String> equalsCustom(ProjectCard p) throws IllegalAccessException, NoSuchFieldException {

        ArrayList<String> changes = new ArrayList<>();

        Field[] thisField = this.getClass().getDeclaredFields();
        Field[] pField = p.getClass().getDeclaredFields();

        for(Field f : thisField ){
          System.out.println(f.getType().toString());
          if ((f.getType().toString().contains("TimePlan")) ||
                  (f.getType().toString().contains("Overtimes")) ||
            (f.getType().toString().contains("DevMethodology")) ||
                  (f.getType().toString().contains("ProjectStage")) ||
                  (f.getType().toString().contains("ProjectType")) ||
                  (f.getType().toString().contains("CardStatus")))
          {
              if (f.getName().contains("timeplan"))
              {
                  if (this.timeplan.id != p.timeplan.id){
                  changes.add(LocalDate.now()+" " +f.getName() +" "+p.getClass().getDeclaredField(f.getName()).get(p).toString());
              }}
              if (f.getName().contains("overtimes"))
              {
                  if (this.overtimes.id != p.overtimes.id){
                      changes.add(LocalDate.now()+" " +f.getName() +" "+p.getClass().getDeclaredField(f.getName()).get(p).toString());
                  }}
              if (f.getName().contains("devMethod"))
              {
                  if (this.devMethod.id != p.devMethod.id){
                      changes.add(LocalDate.now()+" " +f.getName() +" "+p.getClass().getDeclaredField(f.getName()).get(p).toString());
                  }}
              if (f.getName().contains("stage"))
              {
                  if (this.stage.id != p.stage.id){
                      changes.add(LocalDate.now()+" " +f.getName() +" "+p.getClass().getDeclaredField(f.getName()).get(p).toString());
                  }}
              if (f.getName().contains("projectType"))
              {
                  if (this.projectType.id != p.projectType.id){
                      changes.add(LocalDate.now()+" " +f.getName() +" "+p.getClass().getDeclaredField(f.getName()).get(p).toString());
                  }}
              if (f.getName().contains("cardStatus"))
              {
                  if (this.cardStatus.id != p.cardStatus.id){
                      changes.add(LocalDate.now()+" " +f.getName() +" "+p.getClass().getDeclaredField(f.getName()).get(p).toString());
                  }}
          } else
            if (!f.get(this).equals(p.getClass().getDeclaredField(f.getName()).get(p))
            ) {
                changes.add(LocalDate.now()+" " +f.getName() +" "+p.getClass().getDeclaredField(f.getName()).get(p).toString());
            }


        }
        return changes;
    }
       public Boolean findField (String field) throws NoSuchFieldException {


        return ProjectCard.class.getDeclaredField(field).getName().equals(field);
       }
}
