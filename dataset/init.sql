--
-- PostgreSQL database dump
--

-- Dumped from database version 12.14 (Debian 12.14-1.pgdg110+1)
-- Dumped by pg_dump version 12.14 (Debian 12.14-1.pgdg110+1)


-- Database: CMP1611-matheus-ana-ismael

-- DROP DATABASE IF EXISTS "CMP1611-matheus-ana-ismael";

CREATE DATABASE "CMP1611-matheus-ana-ismael"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: check_primeira_receita_prazo(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.check_primeira_receita_prazo() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  IF NEW.cpf_coz IS NOT NULL THEN
    -- Verifica se o cozinheiro tem pelo menos uma receita
    IF (SELECT COUNT(*) FROM RECEITA WHERE cpf_coz = NEW.cpf_coz) = 0 THEN -- primeira receita
      -- Verifica se o cozinheiro está dentro do prazo
      IF NEW.dt_criacao_rec > (SELECT dt_contrato_fun FROM COZINHEIRO WHERE cpf_fun = NEW.cpf_coz) + INTERVAL '45 days' THEN
        RAISE EXCEPTION 'Um cozinheiro recém-contratado tem até 45 dias para entregar sua primeira receita. Após esse período, não é permitido.';
        RETURN NULL;
      END IF;
    END IF;
  END IF;
  RETURN NEW;
END;
$$;


ALTER FUNCTION public.check_primeira_receita_prazo() OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categoria_receita; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria_receita (
    cod_cat_rec integer NOT NULL,
    desc_cat_rec character varying(40) NOT NULL
);


ALTER TABLE public.categoria_receita OWNER TO postgres;

--
-- Name: categoria_receita_cod_cat_rec_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_receita_cod_cat_rec_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_receita_cod_cat_rec_seq OWNER TO postgres;

--
-- Name: categoria_receita_cod_cat_rec_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_receita_cod_cat_rec_seq OWNED BY public.categoria_receita.cod_cat_rec;


--
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    cpf_fun bigint NOT NULL,
    nome_fun character varying(80) NOT NULL,
    dt_contrato_fun date NOT NULL,
    salario_fun numeric(8,2)
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- Name: cozinheiro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cozinheiro (
    nome_fantasia character varying(80),
    ativo_coz boolean DEFAULT true
)
INHERITS (public.funcionario);


ALTER TABLE public.cozinheiro OWNER TO postgres;

--
-- Name: degustador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.degustador (
    ativo_deg boolean DEFAULT true
)
INHERITS (public.funcionario);


ALTER TABLE public.degustador OWNER TO postgres;

--
-- Name: editor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editor (
    ativo_edt boolean DEFAULT true
)
INHERITS (public.funcionario);


ALTER TABLE public.editor OWNER TO postgres;

--
-- Name: ingrediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingrediente (
    cod_ingred integer NOT NULL,
    nome_ingred character varying(40) NOT NULL,
    desc_ingred character varying(150)
);


ALTER TABLE public.ingrediente OWNER TO postgres;

--
-- Name: ingrediente_cod_ingred_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ingrediente_cod_ingred_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ingrediente_cod_ingred_seq OWNER TO postgres;

--
-- Name: ingrediente_cod_ingred_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ingrediente_cod_ingred_seq OWNED BY public.ingrediente.cod_ingred;


--
-- Name: ingrediente_receita; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingrediente_receita (
    cod_rec_ingrec integer NOT NULL,
    cod_ing_ingrec integer NOT NULL,
    quant_ingrec numeric(4,2) NOT NULL,
    med_ingrec character varying(10)
);


ALTER TABLE public.ingrediente_receita OWNER TO postgres;

--
-- Name: COLUMN ingrediente_receita.med_ingrec; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN public.ingrediente_receita.med_ingrec IS 'colher de chá, xícara, ml...';


--
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro (
    isbn integer NOT NULL,
    titulo_livro character varying(200) NOT NULL,
    cpf_edit bigint NOT NULL
);


ALTER TABLE public.livro OWNER TO postgres;

--
-- Name: receita; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.receita (
    cod_rec integer NOT NULL,
    nome_rec character varying(80) NOT NULL,
    dt_criacao_rec date NOT NULL,
    cod_categoria_rec integer NOT NULL,
    cpf_coz bigint NOT NULL,
    isbn_rec integer NOT NULL,
    desc_rec text,
    porcoes_rec integer
);


ALTER TABLE public.receita OWNER TO postgres;

--
-- Name: receita_cod_rec_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.receita_cod_rec_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.receita_cod_rec_seq OWNER TO postgres;

--
-- Name: receita_cod_rec_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.receita_cod_rec_seq OWNED BY public.receita.cod_rec;


--
-- Name: restaurante; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.restaurante (
    cod_rest integer NOT NULL,
    nome_rest character varying(80) NOT NULL
);


ALTER TABLE public.restaurante OWNER TO postgres;

--
-- Name: restaurante_cod_rest_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.restaurante_cod_rest_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.restaurante_cod_rest_seq OWNER TO postgres;

--
-- Name: restaurante_cod_rest_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.restaurante_cod_rest_seq OWNED BY public.restaurante.cod_rest;


--
-- Name: restaurante_cozinheiro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.restaurante_cozinheiro (
    cod_coz_restcoz bigint NOT NULL,
    cod_rest_restcoz integer NOT NULL,
    dt_contratacao date NOT NULL
);


ALTER TABLE public.restaurante_cozinheiro OWNER TO postgres;

--
-- Name: teste; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teste (
    cpf_deg_test bigint NOT NULL,
    cod_rec_test integer NOT NULL,
    dt_test date NOT NULL,
    nota_test numeric NOT NULL
);


ALTER TABLE public.teste OWNER TO postgres;

--
-- Name: categoria_receita cod_cat_rec; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria_receita ALTER COLUMN cod_cat_rec SET DEFAULT nextval('public.categoria_receita_cod_cat_rec_seq'::regclass);


--
-- Name: ingrediente cod_ingred; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente ALTER COLUMN cod_ingred SET DEFAULT nextval('public.ingrediente_cod_ingred_seq'::regclass);


--
-- Name: receita cod_rec; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita ALTER COLUMN cod_rec SET DEFAULT nextval('public.receita_cod_rec_seq'::regclass);


--
-- Name: restaurante cod_rest; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurante ALTER COLUMN cod_rest SET DEFAULT nextval('public.restaurante_cod_rest_seq'::regclass);


--
-- Data for Name: categoria_receita; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria_receita (cod_cat_rec, desc_cat_rec) FROM stdin;
16	Bolo
17	Carne
18	Macarrão
19	Ave
20	Torta
\.


--
-- Data for Name: cozinheiro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cozinheiro (cpf_fun, nome_fun, dt_contrato_fun, salario_fun, nome_fantasia, ativo_coz) FROM stdin;
46589123704	Ana Aline	2023-02-01	5000.00	Cf. Ana	t
72036984513	Matheus Santa	2023-03-01	5000.00	Cf. Matheus	t
31415926535	Samuel Galvão	2023-07-01	5000.00	Cf. Samuel	t
50672841935	Mikael Silva	2023-07-01	5000.00	Cf. Mikael	t
83923454052	 Carlos Santana	2023-01-01	5000.00	Cf. Carlos	t
46567565704	Ana Aline fernandes	2023-02-01	5000.00	Cf. Aline	t
72036987643	Santa Morais	2023-03-01	5000.00	Cf. Santa	t
31411234513	Marco Oliva	2023-07-01	5000.00	Cf. Marco	t
83924761052	Ismael Carlos	2023-01-01	5000.00	Cf. Ismael	t
\.


--
-- Data for Name: degustador; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.degustador (cpf_fun, nome_fun, dt_contrato_fun, salario_fun, ativo_deg) FROM stdin;
12345678901	Felipe dias	2023-04-01	3000.00	t
98765432109	Raimunda ferreira	2023-05-01	3000.00	t
56789012345	Higor Farias	2023-06-01	3000.00	t
24681357902	João Otavio	2023-07-01	3000.00	t
91872534680	Otavio mesquita	2023-07-01	3000.00	t
23418965702	Gilberto Gil	2023-07-01	3000.00	t
12345678906	Felipe dias	2023-04-01	3000.00	t
\.


--
-- Data for Name: editor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.editor (cpf_fun, nome_fun, dt_contrato_fun, salario_fun, ativo_edt) FROM stdin;
13579246801	Geraldo Galvão	2023-07-01	4500.00	t
\.


--
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (cpf_fun, nome_fun, dt_contrato_fun, salario_fun) FROM stdin;
83924761052	Ismael Carlos	2023-01-01	5000.00
46589123704	Ana Aline	2023-02-01	5000.00
72036984513	Matheus Santa	2023-03-01	5000.00
31415926535	Samuel Galvão	2023-07-01	5000.00
50672841935	Mikael Silva	2023-07-01	5000.00
12345678901	Felipe dias	2023-04-01	3000.00
98765432109	Raimunda ferreira	2023-05-01	3000.00
56789012345	Higor Farias	2023-06-01	3000.00
24681357902	João Otavio	2023-07-01	3000.00
91872534680	Otavio mesquita	2023-07-01	3000.00
23418965702	Gilberto Gil	2023-07-01	3000.00
83923454052	Carlos Santana	2023-01-01	5000.00
46567565704	Ana Aline fernandes	2023-02-01	5000.00
72036987643	Santa Morais	2023-03-01	5000.00
31411234513	Marco Oliva	2023-07-01	5000.00
56262343521	Mikael Jackson	2023-07-01	5000.00
13579246801	Geraldo Galvão	2023-07-01	4500.00
\.


--
-- Data for Name: ingrediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingrediente (cod_ingred, nome_ingred, desc_ingred) FROM stdin;
22	Farinha de trigo	Natural 
23	Fermento	Natural
24	Leite	Fresco
25	Baunilha	Estrato
26	Açúcar	Cristal
27	Ovo	Galinha
28	Manteiga	Natural
\.


--
-- Data for Name: ingrediente_receita; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingrediente_receita (cod_rec_ingrec, cod_ing_ingrec, quant_ingrec, med_ingrec) FROM stdin;
1	22	12.00	g
1	23	3.00	g
1	24	20.00	g
1	25	4.00	g
1	26	4.00	g
1	27	2.00	un
1	28	60.00	g
\.


--
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.livro (isbn, titulo_livro, cpf_edit) FROM stdin;
978678	Melhores Receitas	13579246801
\.


--
-- Data for Name: receita; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.receita (cod_rec, nome_rec, dt_criacao_rec, cod_categoria_rec, cpf_coz, isbn_rec, desc_rec, porcoes_rec) FROM stdin;
1	Bolo de Baunilha	2023-01-03	16	83924761052	978678	Pré-aqueça o forno a 180°C e unte uma forma de bolo com manteiga e farinha ou use papel manteiga para forrar o fundo. Em uma tigela grande, bata os ovos e o açúcar até obter uma mistura homogênea e um pouco cremosa. Adicione o leite, o óleo e o extrato de baunilha à mistura de ovos e açúcar, e misture bem. Em outra tigela, peneire a farinha de trigo, o fermento em pó e o sal. Gradualmente, adicione a mistura de ingredientes secos à mistura de ingredientes molhados, mexendo delicadamente até que tudo esteja bem incorporado e não haja mais grumos. Despeje a massa na forma preparada. Asse o bolo no forno pré-aquecido por cerca de 30-35 minutos, ou até que um palito inserido no centro do bolo saia limpo. Retire o bolo do forno e deixe-o esfriar na forma por alguns minutos antes de desenformar. Depois, deixe-o esfriar completamente em uma grade. Se desejar, você pode cobrir o bolo com glacê, açúcar de confeiteiro ou servir simplesmente como está.	\N
2	Bolo de Baunilha	2023-02-04	16	46589123704	978678	Pré-aqueça o forno a 180°C e unte uma forma de bolo com manteiga e farinha ou use papel manteiga para forrar o fundo. Em uma tigela grande, bata os ovos e o açúcar até obter uma mistura homogênea e um pouco cremosa. Adicione o leite, o óleo e o extrato de baunilha à mistura de ovos e açúcar, e misture bem. Em outra tigela, peneire a farinha de trigo, o fermento em pó e o sal. Gradualmente, adicione a mistura de ingredientes secos à mistura de ingredientes molhados, mexendo delicadamente até que tudo esteja bem incorporado e não haja mais grumos. Despeje a massa na forma preparada. Asse o bolo no forno pré-aquecido por cerca de 30-35 minutos, ou até que um palito inserido no centro do bolo saia limpo. Retire o bolo do forno e deixe-o esfriar na forma por alguns minutos antes de desenformar. Depois, deixe-o esfriar completamente em uma grade. Se desejar, você pode cobrir o bolo com glacê de baunilha, açúcar de confeiteiro ou servir simplesmente como está.	\N
4	Bolo de Baunilha 2	2023-02-04	16	46589123704	978678	Pré-aqueça o forno a 180°C e unte uma forma de bolo com manteiga e farinha ou use papel manteiga para forrar o fundo. Em uma tigela grande, bata os ovos e o açúcar até obter uma mistura homogênea e um pouco cremosa. Adicione o leite, o óleo e o extrato de baunilha à mistura de ovos e açúcar, e misture bem. Em outra tigela, peneire a farinha de trigo, o fermento em pó e o sal. Gradualmente, adicione a mistura de ingredientes secos à mistura de ingredientes molhados, mexendo delicadamente até que tudo esteja bem incorporado e não haja mais grumos. Despeje a massa na forma preparada. Asse o bolo no forno pré-aquecido por cerca de 30-35 minutos, ou até que um palito inserido no centro do bolo saia limpo. Retire o bolo do forno e deixe-o esfriar na forma por alguns minutos antes de desenformar. Depois, deixe-o esfriar completamente em uma grade. Se desejar, você pode cobrir o bolo com glacê de baunilha, açúcar de confeiteiro ou servir simplesmente como está.	\N
\.


--
-- Data for Name: restaurante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.restaurante (cod_rest, nome_rest) FROM stdin;
10	Restaurante Mata Fome
11	Restaurante Universitário
12	Pequiseira
\.


--
-- Data for Name: restaurante_cozinheiro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.restaurante_cozinheiro (cod_coz_restcoz, cod_rest_restcoz, dt_contratacao) FROM stdin;
83924761052	10	2023-01-01
46589123704	11	2023-02-01
72036984513	12	2023-03-01
\.


--
-- Data for Name: teste; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.teste (cpf_deg_test, cod_rec_test, dt_test, nota_test) FROM stdin;
12345678901	1	2023-01-20	4.5
56789012345	1	2023-01-20	5.0
24681357902	1	2023-01-20	4.5
91872534680	1	2023-01-20	3.5
23418965702	1	2023-01-20	4.8
98765432109	1	2023-02-25	5.0
98765432109	2	2023-02-25	5.0
\.


--
-- Name: categoria_receita_cod_cat_rec_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_receita_cod_cat_rec_seq', 21, true);


--
-- Name: ingrediente_cod_ingred_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ingrediente_cod_ingred_seq', 28, true);


--
-- Name: receita_cod_rec_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.receita_cod_rec_seq', 4, true);


--
-- Name: restaurante_cod_rest_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.restaurante_cod_rest_seq', 15, true);


--
-- Name: cozinheiro coz_func_cpf; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cozinheiro
    ADD CONSTRAINT coz_func_cpf UNIQUE (cpf_fun);


--
-- Name: ingrediente ingrediente_nome_ingred_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente
    ADD CONSTRAINT ingrediente_nome_ingred_key UNIQUE (nome_ingred);


--
-- Name: livro livro_titulo_livro_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_titulo_livro_key UNIQUE (titulo_livro);


--
-- Name: categoria_receita pk_cod_cat_rec; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria_receita
    ADD CONSTRAINT pk_cod_cat_rec PRIMARY KEY (cod_cat_rec);


--
-- Name: restaurante_cozinheiro pk_cod_coz_restcoz_cod_rest_restcoz; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurante_cozinheiro
    ADD CONSTRAINT pk_cod_coz_restcoz_cod_rest_restcoz PRIMARY KEY (cod_coz_restcoz, cod_rest_restcoz);


--
-- Name: ingrediente pk_cod_ingred; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente
    ADD CONSTRAINT pk_cod_ingred PRIMARY KEY (cod_ingred);


--
-- Name: receita pk_cod_rec; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT pk_cod_rec PRIMARY KEY (cod_rec);


--
-- Name: ingrediente_receita pk_cod_rec_ingred_cod_ing_ingred; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente_receita
    ADD CONSTRAINT pk_cod_rec_ingred_cod_ing_ingred PRIMARY KEY (cod_rec_ingrec, cod_ing_ingrec);


--
-- Name: restaurante pk_cod_rest; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurante
    ADD CONSTRAINT pk_cod_rest PRIMARY KEY (cod_rest);


--
-- Name: funcionario pk_cpf_fun; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT pk_cpf_fun PRIMARY KEY (cpf_fun);


--
-- Name: livro pk_isbn; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT pk_isbn PRIMARY KEY (isbn);


--
-- Name: teste pk_teste; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teste
    ADD CONSTRAINT pk_teste PRIMARY KEY (cpf_deg_test, cod_rec_test);


--
-- Name: receita receita_nome_rec_cpf_coz_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT receita_nome_rec_cpf_coz_key UNIQUE (nome_rec, cpf_coz);


--
-- Name: receita trigger_check_primeira_receita_prazo; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER trigger_check_primeira_receita_prazo BEFORE INSERT ON public.receita FOR EACH ROW EXECUTE FUNCTION public.check_primeira_receita_prazo();


--
-- Name: receita fk_categoria_receita; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT fk_categoria_receita FOREIGN KEY (cod_categoria_rec) REFERENCES public.categoria_receita(cod_cat_rec);


--
-- Name: receita fk_cozinheiro_receita; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT fk_cozinheiro_receita FOREIGN KEY (cpf_coz) REFERENCES public.funcionario(cpf_fun);


--
-- Name: restaurante_cozinheiro fk_cozinheiro_restcoz; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurante_cozinheiro
    ADD CONSTRAINT fk_cozinheiro_restcoz FOREIGN KEY (cod_coz_restcoz) REFERENCES public.funcionario(cpf_fun);


--
-- Name: teste fk_degustador_teste; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teste
    ADD CONSTRAINT fk_degustador_teste FOREIGN KEY (cpf_deg_test) REFERENCES public.funcionario(cpf_fun);


--
-- Name: livro fk_editor_livro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT fk_editor_livro FOREIGN KEY (cpf_edit) REFERENCES public.funcionario(cpf_fun);


--
-- Name: ingrediente_receita fk_ingrediente_ingred; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente_receita
    ADD CONSTRAINT fk_ingrediente_ingred FOREIGN KEY (cod_ing_ingrec) REFERENCES public.ingrediente(cod_ingred);


--
-- Name: receita fk_livro_receita; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.receita
    ADD CONSTRAINT fk_livro_receita FOREIGN KEY (isbn_rec) REFERENCES public.livro(isbn);


--
-- Name: ingrediente_receita fk_receita_ingred; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente_receita
    ADD CONSTRAINT fk_receita_ingred FOREIGN KEY (cod_rec_ingrec) REFERENCES public.receita(cod_rec);


--
-- Name: teste fk_receita_teste; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teste
    ADD CONSTRAINT fk_receita_teste FOREIGN KEY (cod_rec_test) REFERENCES public.receita(cod_rec);


--
-- Name: restaurante_cozinheiro fk_restaurante_restcoz; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.restaurante_cozinheiro
    ADD CONSTRAINT fk_restaurante_restcoz FOREIGN KEY (cod_rest_restcoz) REFERENCES public.restaurante(cod_rest);


--
-- PostgreSQL database dump complete
--

