package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Badge;
import com.inti.formation.iservices.IBadgeService;
import com.inti.formation.repositories.IBadgeRepository;

@Service
public class BadgeService implements IBadgeService {

	@Autowired
	private IBadgeRepository repo;

	@Override
	public Badge saveOrUpdateBadge(Badge badge) {
		return repo.save(badge);
	}

	@Override
	public void deleteBadge(Long idBadge) {
		repo.deleteById(idBadge);
	}

	@Override
	public Badge getByIdBadge(Long idBadge) {
		return repo.findById(idBadge).get();
	}

	@Override
	public List<Badge> getAllBadges() {
		return repo.findAll();
	}

}
