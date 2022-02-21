create view sendDataView as
select l1.id,
       l1.amount,
       l1.mobile,
       l1.transaction_data,
       l1.service_id,
       l1.commission_tax,
       p.personal_num,
       l.acc_number,
       length(l1.id) + length(l1.amount) + length(l1.mobile) + length(l1.transaction_data) + length(l1.service_id) +
       length(l1.commission_tax) + IFNULL(length(p.personal_num),0) + IFNULL(length(l.acc_number), 0)  length
from payment_l1 l1
         left join payment_l2 p on l1.id = p.l1_id
         left join payment_l3 l on p.id = l.l2_id where l1.is_sent = 0 order by l1.commission_tax desc ;