-- 코드를 입력하세요
# 맛으로 조인

SELECT f.flavor
FROM FIRST_HALF f INNER JOIN (SELECT FLAVOR, sum(total_order) as "TOTAL_ORDER"
                           FROM JULY
                           GROUP BY flavor) j
ON f.FLAVOR = j.FLAVOR
order by f.TOTAL_ORDER + j.TOTAL_ORDER desc
limit 3;
