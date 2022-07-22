import { Navbar, Container } from 'react-bootstrap'
import { Link } from 'react-router-dom';
import icon from '../../assets/images/logo-300px.png'

const TopBar = () => {
    return (
        <Navbar bg="dark" variant="dark">
            <Container>
                <Link to="/">
                    <Navbar.Brand >
                        <img
                            alt=""
                            src={icon}
                            width="30"
                            height="30"
                            className="d-inline-block align-top"
                        />{' '}
                        EL BAIVEN
                    </Navbar.Brand>
                </Link>
            </Container>
        </Navbar>
    );
}

export default TopBar;
