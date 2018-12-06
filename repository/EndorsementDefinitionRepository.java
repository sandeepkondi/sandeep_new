package com.beyontec.mol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.EndorsementDefinition;
import com.beyontec.mol.entity.EndorsementDefinition.EndorsementDefinitionId;

@Repository
public interface EndorsementDefinitionRepository extends JpaRepository<EndorsementDefinition, EndorsementDefinitionId> {

    EndorsementDefinition findById(EndorsementDefinitionId id);
}
