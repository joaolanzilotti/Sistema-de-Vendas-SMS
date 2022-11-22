import logo from '../../assets/img/image-header.svg';
import './styles.css';

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="DSMeta" />
                <h1>DSMeta</h1>
                <p>
                    Desenvolvido por
                    <a href="https://github.com/joaosinho2"> JP Corporation</a>
                </p>
            </div>
        </header>
    )
}
export default Header;