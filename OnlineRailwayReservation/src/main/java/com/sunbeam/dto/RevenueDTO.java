package com.sunbeam.dto;

import java.util.List;

public class RevenueDTO {
    private List<Integer> acRevenue;
    private List<Integer> genRevenue;
    private String totalRevenue;

    public RevenueDTO() {
    }

    public RevenueDTO(List<Integer> acRevenue, List<Integer> genRevenue, String totalRevenue) {
        this.acRevenue = acRevenue;
        this.genRevenue = genRevenue;
        this.totalRevenue = totalRevenue;
    }

    public List<Integer> getAcRevenue() {
        return acRevenue;
    }

    public void setAcRevenue(List<Integer> acRevenue) {
        this.acRevenue = acRevenue;
    }

    public List<Integer> getGenRevenue() {
        return genRevenue;
    }

    public void setGenRevenue(List<Integer> genRevenue) {
        this.genRevenue = genRevenue;
    }

    public String getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

}
