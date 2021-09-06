package com.sunbeam.services;

import com.sunbeam.dto.RevenueDTO;
import com.sunbeam.dto.TicketDTO;
import com.sunbeam.dto.UserDTO;

public interface AdminService {
    Boolean saveUser(UserDTO user);
    Boolean updateUser(UserDTO user);
    Boolean deleteUser(UserDTO user);
    Boolean updateTicketStatus(TicketDTO ticketDTOs);
    RevenueDTO getRevenue();
}
