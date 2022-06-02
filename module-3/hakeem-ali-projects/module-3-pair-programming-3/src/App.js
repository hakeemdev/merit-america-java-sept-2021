import './index.css';
import Home from './Pages/Home';
import Header from './Components/Header';
import Footer from './Components/Footer';
import ContactUs from './Pages/Contact-Us';
import { BrowserRouter, Routes , Route} from 'react-router-dom';
function App() {
  return (
    <div> 
      <BrowserRouter>
        <Header/>
          <Routes>
            <Route absoulte path = "/" element ={<Home/>}/>
            <Route  path = "/contact" element ={<ContactUs/>}/>
          </Routes>
        <Footer/>
      </BrowserRouter>
      
      
    </div>
  );
}

export default App;
