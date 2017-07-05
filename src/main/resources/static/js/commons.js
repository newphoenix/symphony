function hashPassword(id) {
		var hashx = sha256_digest($("#"+id).val());
		$("#"+id).val(hashx);
	}