import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/request';
import './styles.css';

type Props = {
    saleId: number;
}

function handleClick(saleId: number){
    axios(`${BASE_URL}/sales/${saleId}/notification`)
    .then(Response =>{
        toast.info("SMS Enviado com Sucesso");
    });
}

function NotificationButtton({saleId} : Props){
    return (
        <div className="dsmeta-red-btn" onClick={() => {handleClick(saleId)}}>
                          <img src={icon} alt="Notificar" />
                        </div>
    )
}
export default NotificationButtton;