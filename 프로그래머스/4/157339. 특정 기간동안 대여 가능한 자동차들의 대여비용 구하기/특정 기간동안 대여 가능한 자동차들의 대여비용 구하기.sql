-- 코드를 입력하세요
select c.CAR_ID, c.CAR_TYPE, round(c.DAILY_FEE * 30 *(1-d.DISCOUNT_RATE/100)) as FEE
from CAR_RENTAL_COMPANY_DISCOUNT_PLAN d 
inner join 
(
select c.CAR_ID, c.CAR_TYPE, c.DAILY_FEE
from CAR_RENTAL_COMPANY_CAR c
where c.CAR_ID not in (select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY where START_DATE <= '2022-11-30' and END_DATE >= '2022-11-1') and c.CAR_TYPE in ('세단', 'SUV')
) c
on d.CAR_TYPE = c.CAR_TYPE
where d.DURATION_TYPE = '30일 이상' and 500000 <= c.DAILY_FEE * 30 *(1-d.DISCOUNT_RATE/100) and c.DAILY_FEE * 30 *(1-d.DISCOUNT_RATE/100) < 2000000
order by FEE desc, c.CAR_TYPE, c.CAR_ID desc;