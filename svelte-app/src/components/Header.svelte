<script>
    import { Navbar } from 'sveltestrap';
    import { Link } from "svelte-navigator";
</script>

<Navbar
        color="dark"
        dark={true}
        light={false}
        class="mb-2"
>
    <Link class="navbar-brand" to="/">HOME</Link>
    <div>
        <Link class="navbar-brand" to="/login">LOGIN</Link>
        <Link class="navbar-brand" to="/register">REGISTER</Link>
    </div>
</Navbar>