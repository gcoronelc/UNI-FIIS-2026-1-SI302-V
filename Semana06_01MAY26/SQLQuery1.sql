select * from educa2..CURSO;

select cur_precio precio from CURSO
where cur_id = 2;


select * from educa2..ALUMNO;

select * from EDUCA2..EMPLEADO;

select * from EDUCA2..MATRICULA;

select * from EDUCA2..PAGO;


select m.cur_id curso, a.alu_id id, alu_nombre alumno, m.mat_nota nota
from ALUMNO a
join MATRICULA m on a.alu_id = m.alu_id
where m.cur_id = 1;


