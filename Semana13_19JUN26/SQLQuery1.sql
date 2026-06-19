

select cur_precio precio from curso where cur_id=5;


select * from curso where cur_id = 3;
select * from matricula where cur_id = 3;
go


update curso set cur_matriculados = cur_matriculados + 1 where cur_id=?;
go


insert into MATRICULA(cur_id, alu_id, emp_id, mat_tipo, mat_fecha, mat_precio, mat_cuotas)
values(?,?,?,?,GETDATE(),?);
go

select count(1) from matricula where cur_id=? and alu_id=?;
go