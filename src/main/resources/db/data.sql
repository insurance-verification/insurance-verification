INSERT INTO vehicle (id, policy_number, effective_date, expire_date, vin, removed)
  VALUES
      (1, '001000', DATEADD('DAY',-180, NOW()), DATEADD('DAY',1, NOW()) , '1FVHG3DV8EHF95976', false),
      (2, '001001', DATEADD('DAY',-180, NOW()), DATEADD('DAY',1, NOW()) , 'JF2SHAGC5CH486528', false),
      (3, '001002', DATEADD('DAY',-180, NOW()), DATEADD('DAY',1, NOW()) , '1FBJS31Y2HHC97634', false),
      (4, '001002', DATEADD('DAY',-18, NOW()) , DATEADD('DAY',1, NOW()) , '1HGCG55471A191706', false),
      (5, '001003', DATEADD('DAY',-180, NOW()), DATEADD('DAY',-7, NOW()), '3D2WG46A07G792665', true);