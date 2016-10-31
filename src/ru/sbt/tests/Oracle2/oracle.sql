/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  artem
 * Created: Oct 30, 2016
 */

-- 1
select id from tab1
union all
select id from tab2

-- 2
select id from tab1
union
select id from tab2

-- 3
select id from tab1
intersect
select id from tab2

-- 4
select id from tab1
minus
select id from tab2