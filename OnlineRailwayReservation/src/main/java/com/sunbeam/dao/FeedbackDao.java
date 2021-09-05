package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entity.Feedback;
import com.sunbeam.entity.PassengerTicket;
import com.sunbeam.entity.Train;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
	Feedback findById(Long Id);
}
