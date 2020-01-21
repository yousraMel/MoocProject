package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Badge;

public interface IBadgeService {
	
	public Badge saveOrUpdateBadge(Badge badge);
	public void deleteBadge (Long idBadge);
	public Badge getByIdBadge(Long idBadge);
	public List<Badge> getAllBadges();

}
