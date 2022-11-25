import NotificationButtton from "./components/notificationbutton";
import Header from "./components/Header";
import SalesCard from "./components/SalesCard";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
function App() {
  return (
    <>
    <ToastContainer />
    <Header />
    <SalesCard />
    </>
  )
}

export default App;
