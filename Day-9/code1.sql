select s.semester,s.year,count(p.id) as no_of_professor from schedule s join professor p on s.professor_id = p.id 
group by p.id 
order by year;