package pl.coderslab.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private int id;
    private LocalDateTime orderDate;
    private LocalDate plannedRepairStart;
    private LocalDateTime repairStart;
    private Employee employee;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private Vehicle vehicle;
    private BigDecimal repairCost;
    private BigDecimal partsCost;
    private int workingHours;
    private LocalDate repairEnd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPlannedRepairStart() {
        return plannedRepairStart;
    }

    public void setPlannedRepairStart(LocalDate plannedRepairStart) {
        this.plannedRepairStart = plannedRepairStart;
    }

    public LocalDateTime getRepairStart() {
        return repairStart;
    }

    public void setRepairStart(LocalDateTime repairStart) {
        this.repairStart = repairStart;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public BigDecimal getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(BigDecimal repairCost) {
        this.repairCost = repairCost;
    }

    public BigDecimal getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(BigDecimal partsCost) {
        this.partsCost = partsCost;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public LocalDate getRepairEnd() {
        return repairEnd;
    }

    public void setRepairEnd(LocalDate repairEnd) {
        this.repairEnd = repairEnd;
    }
}
