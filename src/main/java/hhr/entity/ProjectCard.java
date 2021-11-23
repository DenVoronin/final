package hhr.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "project")
public class ProjectCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; // ID проекта
    String client; // Кто заказчик проекта
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_status")
    CardStatus cardStatus; // Статус карточки
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_type")
    ProjectType projectType; // Тип проекта
    @Basic
    @Column(name = "id_employee")
    int idEmployee; // Автор карточки
    String name; // Наименование проекта
    @Basic
    @Column(name = "func_area",length = 65535,columnDefinition="Text")
    String funcArea; // Функциональное направление
    @Basic
    @Column(name = "subject_area", length = 65535,columnDefinition="Text")
    String subjectArea; // Предметная область проекта
    @Column(length = 65535,columnDefinition="Text")
    String description; // Описание проекта
    @Column(length = 65535,columnDefinition="Text")
    String tasks; // Задачи, которые придется решать на проекте
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "stage")
    ProjectStage stage; // Стадия проекта
    @Basic
    @Column(name = "dead_line")
    LocalDate deadLine; // Срок завершения проекта
    @Column(length = 65535,columnDefinition="Text")
    String technoligies; // Технологии
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "dev_method")
    DevMethodology devMethod; // Методология разработки
    int stakeHolders; //Сколько стейкхолдеров на проекте
    Boolean product; // Продуктовая разработка
    int analitics; // Количество аналитиков
    int devs; // Количество разработчиков
    Boolean testers; // Тестировщики
    Boolean techWriters; // Техписы
    int team; // Количесво людей в команде
    @Column(length = 65535,columnDefinition="Text")
    String location; // Локация
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "timeplan")
    TimePlan timeplan; // График времени
    @Basic
    @Column(name = "deadline_hr")
    LocalDate deadlineHR; // Дата вывода людей на проект
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "overtimes")
    Overtimes overtimes; // Овертаймы
    @Column(name = "hr_details",length = 65535,columnDefinition="Text")
    String hrDetails; // Процедура вывода людей
    Boolean gost; // Будет ли документирование по ГОСТ

ProjectCard(){}

    public ProjectCard(String client, String funcArea,
                String subjectArea,String description, String tasks,
                Boolean gost, String hrDetails )
    {
        this.client = client;
        this.funcArea= funcArea;
        this.subjectArea = subjectArea;
        this.description = description;
        this.tasks = tasks;
        this.gost = gost;
        this.hrDetails = hrDetails;
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

    public int getIdEmployee() {
        return idEmployee;
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

    public int getStakeHolders() {
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

}
