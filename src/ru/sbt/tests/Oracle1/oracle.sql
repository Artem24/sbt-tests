/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  artem
 * Created: Oct 30, 2016
 */

select tc.idt_client, tc.address, tn.t_name, ts.t_surname, tf.t_family
from t_client tc
left join t_property tp on tc.idt_client = tp.idt_client
left join t_name tn on tp.propertykind = 'name' and tp.contentid = tn.idt_name
left join t_surname ts on tp.propertykind = 'surname' and tp.contentid = ts.idt_surname
left join t_family tf on tp.propertykind = 'family' and tp.contentid = tf.idt_family
group by tc.idt_client, tc.address, tn.t_name, ts.t_surname, tf.t_family
