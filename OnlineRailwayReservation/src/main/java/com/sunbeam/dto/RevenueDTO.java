package com.sunbeam.dto;

import java.util.List;

public class RevenueDTO {
    private Double acRevenue[];
    private Double genRevenue[];
    private Double totalRevenue;

    public RevenueDTO() {
    }

    public RevenueDTO(Double[] acRevenue, Double[] genRevenue, Double totalRevenue) {
        this.acRevenue = acRevenue;
        this.genRevenue = genRevenue;
        this.totalRevenue = totalRevenue;
    }

    public Double[] getAcRevenue() {
        return acRevenue;
    }

    public void setAcRevenue(Double[] acRevenue) {
        this.acRevenue = acRevenue;
    }

    public Double[] getGenRevenue() {
        return genRevenue;
    }

    public void setGenRevenue(Double[] genRevenue) {
        this.genRevenue = genRevenue;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

}
