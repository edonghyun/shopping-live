<script lang="ts">
    import { onMount } from 'svelte';
    import { writable } from 'svelte/store'
    import { Col, Row  } from 'sveltestrap';
    import DateFilter from '../components/DateFilter.svelte';
    import { getBroadcasts } from '../client';

    const x = writable({
        data: undefined,
    });

    onMount(async () => {
        const data = await getBroadcasts();
        $x.data = data;
    });

</script>

<DateFilter />
{#if !$x.data}
    <p>...Loading</p>
{:else }
    {#each $x.data.content as broadcast}
        <Col class="broadcast-box-wrapper" xs="12" sm="6" md="4" lg="3">
            <div class="broadcast-container">
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">REMOTE ID:</span> </Col>
                    <Col class="text-center" xs="6">{broadcast.remoteId}</Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">FROM:</span></Col>
                    <Col class="text-center" xs="6">{broadcast.provider}</Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">DISPLAY TYPE:</span></Col>
                    <Col class="text-center" xs="6">{broadcast.extraData.displayType}</Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">SERVICE NAME:</span></Col>
                    <Col class="text-center" xs="6">{broadcast.extraData.serviceName}</Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">PROFILE IMAGE:</span></Col>
                    <Col class="text-center" xs="6">
                        <img class="broadcast-profile-image" src={broadcast.extraData.profileImage}/>
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">BROADCAST TITLE:</span></Col>
                    <Col class="text-center" xs="6">
                        {broadcast.extraData.broadcastTitle}
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">BROADCAST TYPE:</span></Col>
                    <Col class="text-center" xs="6">
                        {broadcast.extraData.broadcastType}
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">BRIDGE TITLE:</span></Col>
                    <Col class="text-center" xs="6">
                        {broadcast.extraData.broadcastBridgeTitle}
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">START DATE:</span></Col>
                    <Col class="text-center" xs="6">
                        {broadcast.extraData.startDate}
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-right" xs="6"><span class="broadcast-info-head">EXPECTED START DATE:</span></Col>
                    <Col class="text-center" xs="6">
                        {broadcast.extraData.expectedStartDate}
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-center" xs="6"><span class="broadcast-info-head">BROADCAST STATUS:</span></Col>
                    <Col class="text-center" xs="6">
                        {broadcast.extraData.status}
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-center" xs="12"><span class="broadcast-info-head">BROADCAST STANDBY IMAGE:</span></Col>
                    <Col class="text-center" xs="12">
                        <img class="broadcast-bridge-image-pc" src={broadcast.extraData.broadcastStandByImage}/>
                    </Col>
                </Row>
                <Row class="p-3">
                    <Col class="text-center" xs="12"><span class="broadcast-info-head">BRIDGE IMAGE:</span></Col>
                    <Col class="text-center" xs="12">
                        <img class="broadcast-bridge-image-pc" src={broadcast.extraData.broadcastBridgePcImage}/>
                    </Col>
                </Row>
            </div>
        </Col>
    {/each}
{/if}



