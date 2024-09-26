-- Rename 'createdAt' to 'created_at'
ALTER TABLE airport CHANGE createdAt created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

-- Rename 'modifiedAt' to 'modified_at'
ALTER TABLE airport CHANGE modifiedAt modified_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
