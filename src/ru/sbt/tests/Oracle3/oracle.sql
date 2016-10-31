/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  artem
 * Created: Oct 30, 2016
 */

insert into HIERARCHY values (1, '1', null);
insert into HIERARCHY values (2, '1.2', 1);
insert into HIERARCHY values (3, '1.3', 1);
insert into HIERARCHY values (4, '2.1', 2);
insert into HIERARCHY values (5, '2.2', 2);
insert into HIERARCHY values (6, '5.1', 5);
insert into HIERARCHY values (7, '6.1', 6);


select level, id, parent, name 
from HIERARCHY 
start with parent is null
connect by prior id = parent

