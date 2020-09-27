package com.campusedu.devexercise.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.opencsv.bean.CsvBindByName;
    
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CsvBindByName(column = "advising_requisite_code")
    private String advisingRequisiteCode;
    @CsvBindByName(column = "core_literature_requirement")
    private String coreLiteratureRequirement;
    @CsvBindByName(column = "course_catalog_text")
    @Column(columnDefinition = "text")
    private String catalogText;
    @CsvBindByName(column = "course_code")
    private String code;
    @CsvBindByName(column = "course_code_number")
    private Integer codeNumber;
    @CsvBindByName(column = "course_code_prefix")
    private String prefix;
    @CsvBindByName(column = "course_code_sanitized")
    private String codeSanitized;
    @CsvBindByName(column = "course_fees")
    private String fees;
    @CsvBindByName(column = "course_title")
    private String title;
    @CsvBindByName(column = "default_credit_hours")
    private String defaultCreditHours;
    @CsvBindByName(column = "division_code")
    private String divisionCode;
    @CsvBindByName(column = "fee_type")
    private String feeType;
    @CsvBindByName(column = "fixed_variable_credit")
    private String fixedVariableCredit;
    @CsvBindByName(column = "max_credit_hours")
    private Integer maxCreditHours;
    @CsvBindByName(column = "min_credit_hourse")
    private Integer minCreditHours;

    public String getAdvisingRequisiteCode() {
        return this.advisingRequisiteCode;
    }
    public String getCoreLiteratureRequirement() {
        return this.coreLiteratureRequirement;
    }
    public String getCatalogText() {
        return this.catalogText;
    }
    public String getCode() {
        return this.code;
    }
    public Integer getCodeNumber() {
        return this.codeNumber;
    }
    public String getPrefix() {
        return this.prefix;
    }
    public String getCodeSanitized() {
        return this.codeSanitized;
    }
    public String getFees() {
        return this.fees;
    }
    public String getTitle() {
        return this.title;
    }
    public String getDefaultCreditHours() {
        return this.defaultCreditHours;
    }
    public String getDivisionCode() {
        return this.divisionCode;
    }
    public String getFeeType() {
        return this.feeType;
    }
    public String getFixedVariableCredit() {
        return this.fixedVariableCredit;
    }
    public Integer getMaxCreditHours() {
        return this.maxCreditHours;
    }
    public Integer getMinCreditHours() {
        return this.minCreditHours;
    }
}